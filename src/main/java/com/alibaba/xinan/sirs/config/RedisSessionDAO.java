package com.alibaba.xinan.sirs.config;

import com.alibaba.xinan.sirs.util.RedisUtils;
import com.alibaba.xinan.sirs.util.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义的 session dao 来进行 session 管理，其实就是对session的增删改查
 *
 * @author XinAnzzZ
 * @date 2019/1/10 15:59
 */
@Component
public class RedisSessionDAO extends AbstractSessionDAO {

    /*** shiro session 前缀 */
    private static final String SHIRO_SESSION_PREFIX = "sirs-session:";

    /*** shiro session 过期时间 300s 5分钟 */
    private static final int SHIRO_SESSION_EXPIRE = 300;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        String sessionKey = getSessionKey(sessionId);
        return getSession(redisUtils.get(sessionKey));
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }
        String sessionKey = getSessionKey(session.getId());
        redisUtils.deleteByKey(sessionKey);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<String> keySet = redisUtils.keys(SHIRO_SESSION_PREFIX);
        Set<Session> sessionSet = new HashSet<>(16);
        keySet.forEach(key -> sessionSet.add(getSession(redisUtils.get(key))));
        return sessionSet;
    }

    /**
     * 获取自定义 session key
     *
     * @param sessionId the session id
     */
    private String getSessionKey(Serializable sessionId) {
        return SHIRO_SESSION_PREFIX + sessionId;
    }

    private Session getSession(String sessionValue) {
        if (StringUtils.isEmpty(sessionValue)) {
            return null;
        }
        return (Session) SerializationUtils.deserialize(sessionValue.getBytes());
    }

    /**
     * 保存session
     *
     * @param session the session
     */
    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {
            Serializable sessionId = generateSessionId(session);
            String sessionKey = getSessionKey(sessionId);
            String sessionValue = Arrays.toString(SerializationUtils.serialize(session));
            redisUtils.set(sessionKey, sessionValue, SHIRO_SESSION_EXPIRE);
        }
    }
}

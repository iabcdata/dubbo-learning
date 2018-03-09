package io.iabc.dubbo.demoa.share.service;

import io.iabc.dubbo.demoa.share.dto.UserDTO;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 14:01 2016年08月03日.
 */
public interface HeyService {

    /**
     * example:
     * curl -X POST -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/user/update --data-ascii '{"userId":13922,"name":高山峰}'
     * curl -X GET -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/hey/status
     * curl -X GET -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/hey/user?userId=13922
     * curl -X GET -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/hey/user/13922
     * curl -X POST -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/hey/user/query --data-ascii '{"userId":13922,"name":"高山峰"}'
     * curl -X PUT -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/hey/user/update --data-ascii '{"userId":13922,"name":"高山峰"}'
     * curl -X DELETE -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/hey/user?userId=13922
     * curl -X DELETE -H "Content-Type: application/json" http://127.0.0.1:8088/demoa/hey/user/13922
     */

    /**
     * 无参数状态校验接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/status)
     *
     * @return
     */
    String status();

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user?userId=13922)
     *
     * @param userId 用户ID
     * @return
     */
    Object getUser(Long userId);

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user/13922)
     *
     * @param userId 用户ID
     * @return
     */
    Object getUser2(Long userId);

    /**
     * 更新用户信息(示例:curl -X POST -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user/query --data-ascii
     * '{"userId":13922,"name":"高山峰"}')
     *
     * @param userDTO
     * @return
     */
    Object queryUser(UserDTO userDTO);

    /**
     * 更新用户信息(示例:curl -X PUT -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user/update --data-ascii
     * '{"userId":13922,"name":"高山峰"}')
     *
     * @param userDTO
     * @return
     */
    Boolean updateUser(UserDTO userDTO);

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X DELETE -H "Content-Type: application/json"
     * http://{IP}:{PORT}/heyx/hey/user?userId=13922)
     *
     * @param userId 用户ID
     * @return
     */
    Object delUser(Long userId);

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X DELETE -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/13922)
     *
     * @param userId 用户ID
     * @return
     */
    Object delUser2(Long userId);

}
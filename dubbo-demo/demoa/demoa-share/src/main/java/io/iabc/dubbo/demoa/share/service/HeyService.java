package io.iabc.dubbo.demoa.share.service;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.iabc.dubbo.demoa.share.dto.CookiesDTO;
import io.iabc.dubbo.demoa.share.dto.UserDTO;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 * Created on 14:01 2016年08月03日.
 */
@Path("hey")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
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
    @GET
    @Path("status")
    String status();
    
    @GET
    @Path("cookies")
    String cookies(@BeanParam CookiesDTO cookiesDTO);

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user?userId=13922)
     *
     * @param userId 用户ID
     * @return
     */
    @GET
    @Path("user")
    Object getUser(@QueryParam("userId") Long userId);

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user/13922)
     *
     * @param userId 用户ID
     * @return
     */
    @GET
    @Path("user/{userId}")
    Object getUser2(@PathParam("userId") Long userId);

    /**
     * 更新用户信息(示例:curl -X POST -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user/query --data-ascii
     * '{"userId":13922,"name":"高山峰"}')
     *
     * @param userDTO
     * @return
     */
    @POST
    @Path("user/query")
    Object queryUser(UserDTO userDTO);

    /**
     * 更新用户信息(示例:curl -X PUT -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/user/update --data-ascii
     * '{"userId":13922,"name":"高山峰"}')
     *
     * @param userDTO
     * @return
     */
    @POST
    @Path("user/update")
    Boolean updateUser(UserDTO userDTO);

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X DELETE -H "Content-Type: application/json"
     * http://{IP}:{PORT}/heyx/hey/user?userId=13922)
     *
     * @param userId 用户ID
     * @return
     */
    @DELETE
    @Path("user")
    Object delUser(@QueryParam("userId") Long userId);

    /**
     * 根据请求参数获取用户信息接口(示例:curl -X DELETE -H "Content-Type: application/json" http://{IP}:{PORT}/heyx/hey/13922)
     *
     * @param userId 用户ID
     * @return
     */
    @DELETE
    @Path("user/{userId}")
    Object delUser2(@PathParam("userId") Long userId);

}
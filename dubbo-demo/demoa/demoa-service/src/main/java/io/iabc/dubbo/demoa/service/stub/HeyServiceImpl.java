 /*
  * Copyright 2017-2018 Iabc Co.Ltd.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *      http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */

 package io.iabc.dubbo.demoa.service.stub;

 import com.alibaba.dubbo.config.annotation.Service;

 import io.iabc.dubbo.demoa.share.dto.CookiesDTO;
 import io.iabc.dubbo.demoa.share.dto.UserDTO;
 import io.iabc.dubbo.demoa.share.service.HeyService;

 /**
  * Project: dubbo-learning
  * TODO:
  *
  * @author <a href="mailto:h@iabc.io">shuchen</a>
  * @version V1.0
  * @since 2018-03-12 15:07
  */
 @Service(protocol = { "rest", "dubbo" }, timeout = 10000)
 public class HeyServiceImpl implements HeyService {

     @Override
     public String status() {
         return "ok";
     }

     @Override
     public String cookies(CookiesDTO cookiesDTO) {
         return cookiesDTO.toString();
     }

     @Override
     public Object getUser(Long userId) {
         return "not implemented";
     }

     @Override
     public Object getUser2(Long userId) {
         return "not implemented";
     }

     @Override
     public Object queryUser(UserDTO userDTO) {
         return "not implemented";
     }

     @Override
     public Boolean updateUser(UserDTO userDTO) {
         return true;
     }

     @Override
     public Object delUser(Long userId) {
         return "not implemented";
     }

     @Override
     public Object delUser2(Long userId) {
         return "not implemented";
     }
 }

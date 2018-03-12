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

 package io.iabc.dubbo.rest.hey.service.controller;

 import com.alibaba.dubbo.config.annotation.Service;

 import javax.annotation.Resource;

 import io.iabc.dubbo.rest.hex.share.service.HexService;
 import io.iabc.dubbo.rest.hey.share.service.HeyService;

 /**
  * Project: dubbo-learning
  * TODO:
  *
  * @author <a href="mailto:h@iabc.io">shuchen</a>
  * @version V1.0
  * @since 2018-03-09 15:09
  */
 @Service(protocol = { "rest", "dubbo" }, timeout = 10000)
 public class HeyServiceImpl implements HeyService {

     @Resource
     private HexService hexService;

     @Override
     public String test() {
         String invokeResult = hexService.echoSimple("invoke hexService");
         return invokeResult;
     }

     @Override
     public String status() {
         return "ok";
     }

     @Override
     public String hello(String msg) {
         return "hello " + msg;
     }
 }

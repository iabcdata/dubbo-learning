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

 package io.iabc.dubbo.rest.hey.service;

 import org.eclipse.jetty.server.Connector;
 import org.eclipse.jetty.server.Server;
 import org.eclipse.jetty.server.ServerConnector;
 import org.eclipse.jetty.webapp.WebAppContext;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

 /**
  * Project: dubbo-learning
  * TODO:
  *
  * @author <a href="mailto:h@iabc.io">shuchen</a>
  * @version V1.0
  * @since 2018-03-09 14:59
  */
 public class Launcher {
     private static final String CONTEXT = "/hey";
     private static int PORT = 8088;
     private static String DEFAULT_WEBAPP_PATH = "hey-service/src/main/webapp";
     private static Logger logger = LoggerFactory.getLogger(Launcher.class);

     public static void main(String[] args) {
         logger.info("server start...");
         if (args != null && args.length == 2) {
             try {
                 DEFAULT_WEBAPP_PATH = args[0];
                 PORT = Integer.parseInt(args[1]);
             } catch (Exception e) {
                 logger.error(e.getMessage(), e);
                 System.exit(-1);
             }
         }
         new Launcher().startJetty();
     }

     /**
      * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
      *
      * @param port        端口号
      * @param contextPath web工程路径
      * @return jettey Server
      */
     public static Server createServerInSource(int port, String contextPath) {
         Server server = new Server();
         server.setStopAtShutdown(true);
         ServerConnector connector = new ServerConnector(server);
         //        connector.setPort(port); dubbo服务端口在dubbo配置文件中指定
         connector.setReuseAddress(true);
         server.setConnectors(new Connector[]{connector});
         WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
         webContext.setDescriptor(DEFAULT_WEBAPP_PATH + "/WEB-INF/web.xml");
         webContext.setResourceBase(DEFAULT_WEBAPP_PATH);
         webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
         server.setHandler(webContext);
         return server;
     }

     /**
      * 启动jetty服务
      */
     public void startJetty() {
         try {
             final Server server = Launcher.createServerInSource(PORT, CONTEXT);
             server.stop();
             server.start();
             server.join();
         } catch (Exception e) {
             logger.error(e.getMessage(), e);
             System.exit(-1);
         }
     }
 }

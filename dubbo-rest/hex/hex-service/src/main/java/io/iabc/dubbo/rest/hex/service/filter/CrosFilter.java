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

 package io.iabc.dubbo.rest.hex.service.filter;

 import java.io.IOException;

 import javax.servlet.Filter;
 import javax.servlet.FilterChain;
 import javax.servlet.FilterConfig;
 import javax.servlet.ServletException;
 import javax.servlet.ServletRequest;
 import javax.servlet.ServletResponse;
 import javax.servlet.http.HttpServletResponse;

 /**
  * Project: dubbo-learning
  * TODO:
  *
  * @author <a href="mailto:h@iabc.io">shuchen</a>
  * @version V1.0
  * @since 2018-03-09 14:57
  */
 public class CrosFilter implements Filter {
     public CrosFilter() {
     }

     public void init(FilterConfig filterConfig) throws ServletException {
     }

     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
         HttpServletResponse res = (HttpServletResponse) response;
         res.setHeader("Access-Control-Allow-Origin", "*");
         res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
         res.setHeader("Access-Control-Max-Age", "3600");
         res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
         chain.doFilter(request, response);
     }

     public void destroy() {
     }
 }

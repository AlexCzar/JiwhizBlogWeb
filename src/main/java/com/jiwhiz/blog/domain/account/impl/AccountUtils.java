/* 
 * Copyright 2013 JIWHIZ Consulting Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jiwhiz.blog.domain.account.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jiwhiz.blog.domain.account.UserAccount;

/**
 * 
 * @author Yuan Ji
 * 
 */
public class AccountUtils {
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    static UserAccount getLoginUserAccount() {
        if (getAuthentication() != null && getAuthentication().getPrincipal() instanceof UserAccount) {
            return (UserAccount)getAuthentication().getPrincipal();
        }
        return null;
    }

    static String getLoginUserId() {
        UserAccount account = getLoginUserAccount();
        return (account == null) ? null : account.getUserId();
    }

    private AccountUtils() {}
}

package com.ml.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * 0. No Auth:
 * http://localhost:8090/api/hello/xj
 *
 * 1.Basic Auth:
 * http://localhost:8090/ba/ical/xj (ml/ml2)
 *
 * 2.Basic Auth:
 *http://localhost:8090/ba/admin/xj (ml/ml2)
 *
 *
 * 3.OAuth2:
 * 3.1: get tokeon:
 * 	url:
 * 		http://localhost:8090/oauth/token?grant_type=password&username=bill&password=abc123*
 * 	head authorization:
 * 		username: my-trusted-client/password: secret
 *
 * 	return:
 *    {
 *     "access_token": "2eb9d2c5-d33c-4486-b7db-4ca9c1af1a5f",
 *     "token_type": "bearer",
 *     "refresh_token": "fa2269e8-7e12-4aef-9d6d-973b93a4070e",
 *     "expires_in": 119,
 *     "scope": "read write trust"
 * }
 *
 * 3.2: redirect with token:
 * 		http://localhost:8090/oa/ical/?access_token=90cb56d0-c0c5-4ace-88b1-9850517e0fc9
 *
 *
 *
 *
 */
@SpringBootApplication
public class IcalBasicAutherticationApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(IcalBasicAutherticationApplication.class, args);
  }
}

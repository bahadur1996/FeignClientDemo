package com.example.feginclientdemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customizationClient", url = "${client.baseurl.dashboard}")
public interface DashboardUserClient {

    @GetMapping("customization-common/rest/v1/{accountId}")
    Response<CustomizationCommonDto> getCustomMessages(@PathVariable("accountId") String accountId);
}
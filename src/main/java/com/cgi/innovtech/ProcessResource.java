package com.cgi.innovtech;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/process")
public class ProcessResource {

    private final RuntimeService runtimeService;

    @PostMapping(value = "/{processName}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String startProcess(
            @ApiParam(value = "Nom du processus", required = true, example = "innov-tech-process") @PathVariable("processName") String processName) {
        log.info("Start process ...");
        // see at http://localhost:8080/camunda/app/cockpit/
        // add http://localhost:8080/engine-rest/engine/default/process-definition
        return runtimeService.startProcessInstanceByKey(processName).getProcessInstanceId();
    }

}

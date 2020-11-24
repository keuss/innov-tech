package com.cgi.innovtech;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

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
        // http://localhost:8080/swagger-ui/index.html
        // see at http://localhost:8080/camunda/app/cockpit/
        // add http://localhost:8080/engine-rest/engine/default/process-definition
        Map<String, Object> variables = Collections.singletonMap("date", LocalDateTime.now());
        return runtimeService.startProcessInstanceByKey(processName, variables).getProcessInstanceId();
    }

}

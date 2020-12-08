package com.cgi.innovtech;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/process")
public class ProcessRessource {

    // TODO start process instance !

    @PostMapping(value = "/{processName}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String start(@PathVariable String processName) {
        log.info("Start ...");
        // TODO return process instance id
        return null;
    }
}

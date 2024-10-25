package hello.springmvc.basic;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.info(name);
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "ok";
        // 뷰에 출력
    }

}

package org.bbosiregi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/ocr")
public class OcrController {
    @Autowired
    private ClovaOCR clovaOCR;

    @PostMapping( "/parse")
    public String parseImage(@RequestBody ImageParsingRequest request) {
        return clovaOCR.execute(request);
    }
}

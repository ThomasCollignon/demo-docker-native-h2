package org.coli.demodockernativeh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(HintsRegistrar.class)
public class Demodockernativeh2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demodockernativeh2Application.class, args);
    }
}

package org.coli.demodockernativeh2;

import lombok.RequiredArgsConstructor;
import org.coli.demodockernativeh2.persistence.RouteDB;
import org.coli.demodockernativeh2.persistence.RouteDBRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

import static java.util.List.of;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final RouteDBRepository routeDBRepository;

    @GetMapping("/")
    String home() {
        return "hello from demo docker native H2";
    }

    @GetMapping("/getIndex")
    int getIndex() {
        return routeDBRepository.findAll().get(0).getCurrentIndex();
    }

    @PostMapping("fillDB")
    void fillDB() {
        Stream.of("A", "B", "C", "D")
              .map(key -> new RouteDB(key, of(of("coucou " + key)), 0))
              .map(this.routeDBRepository::save)
              .forEach(System.out::println);
    }
}

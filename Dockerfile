FROM ubuntu:22.04
COPY ./target/demodockernativeh2 demodockernativeh2
ENTRYPOINT ["/demodockernativeh2"]


### ping_pong_java_rmi_mixed_mode

* Example of co-dependent services in Java RMI
* PingService uses vanilla Java RMI
* PongService uses Spring Java RMI with Java configuration
* details are shielded by PingServiceClient and PongServiceModernClient
* Registry and Monitor use the above clients
    * note that Monitor predicates on the `pongServiceEndpoint` registry entry

### Notes

* Both `PingService` and `PongService` append a message to a `Ball` object, and then call the other service.
    * `Ping` uses `Pong`
    * `Pong` uses `Ping` 
* The `Ball` info object has a max payload, and `Ping` and `Pong` will stop when the max is reached.

### To Run

* in window 0: `gradle :Registry:run`
    * this is a stand-alone which the services will use
* in window 1: `gradle :PingService:run`
* in window 2: `gradle :PongService:run`
* in window 3: `./run_client.sh`
* alternatively, in window 4: `gradle :Monitor:run`
    * will run a health-check on services

### Commands

* `i` to use PingService
* `o` to use PongService
* `r` to list registry
* `q` to quit

### Notes

* `client` must be run _in situ_ because it uses `stdin`

# Students app

## App should (*user stories*):
* system **read/get** *students* data (file, db, etc)
* system **sort**  *students* according to selected algorithm (print benchmarking for sorting)
* system **save** sorted *students* (file, db, ect)


## App architecture: 
* based on **clean architecture**
* *domain* layer contains app domain model
* *use case* layer is same as service layer, contains business logic
* *adapter* layer contains connections with infrastructure and UI.
* layers connected by ports



# Discount Shop API – Starter (REST)

Starterprojekt für die Übung **Webservices und REST**.

## Ziele des Starters
- Struktur: api/service/domain/repo
- Fokus auf REST-Kernaspekte: URIs, Methoden, Statuscodes, DTOs, Validierung
- Grundlange Fehlerhandling über ein zentrales `@ControllerAdvice` (ProblemDetails)

## Start
Anwendung starten:
```bash
mvn spring-boot:run
```

Unit Tests ausführen:
```bash
mvn test
```

Integrationstests ausführen (inkl. Unit Tests):
```bash
mvn verify
```

## Quick Checks

Servicestatus prüfen:

```bash
curl -i http://localhost:8080/actuator/health
```

Neue Bestellung (`order`) anlegen:

```bash
curl -i -X POST http://localhost:8080/orders
```

Der Bestellung ein Produkt (`item`) hinzufügen (ID der oben neu erstellten Bestellung übernehmen!):
```bash
curl -i -X POST http://localhost:8080/orders/<ID>/items \
  -H "Content-Type: application/json" \
  -d '{ "productId": "P2", "quantity": 2 }'
```

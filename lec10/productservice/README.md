# Product REST API (Minimal Spring Boot Example)

Dieses Projekt zeigt ein minimales Spring Boot REST-Beispiel für **Product-CRUD**:
- keine DTOs
- keine zentrale Fehlerbehandlung
- keine Datenbank (In-Memory)

## Voraussetzungen
- Java (z. B. JDK 17/21)
- Maven

## Starten
```bash
mvn spring-boot:run
```

Standardmäßig läuft die Anwendung unter:
- `http://localhost:8080`

## REST-Endpunkte (Überblick)
- `GET    /products` — alle Produkte
- `GET    /products/{id}` — ein Produkt (liefert bei unbekannter ID `null`)
- `POST   /products` — Produkt anlegen
- `PUT    /products/{id}` — Produkt ersetzen/überschreiben (legt bei unbekannter ID ebenfalls an)
- `DELETE /products/{id}` — Produkt löschen

## Schnelltest mit curl

### 1) Produkt anlegen (POST)
```bash
curl -i -X POST "http://localhost:8080/products" \
  -H "Content-Type: application/json" \
  -d '{"name":"Keyboard","price":49.99}'
```

### 2) Alle Produkte anzeigen (GET)
```bash
curl -i "http://localhost:8080/products"
```

### 3) Ein Produkt per ID anzeigen (GET)
> Hinweis: Die ID wird beim POST serverseitig vergeben (z. B. 1001, 1002, ...).
```bash
curl -i "http://localhost:8080/products/1001"
```

### 4) Produkt ersetzen/aktualisieren (PUT)
```bash
curl -i -X PUT "http://localhost:8080/products/1001" \
  -H "Content-Type: application/json" \
  -d '{"name":"Keyboard Pro","price":79.99}'
```

### 5) Produkt löschen (DELETE)
```bash
curl -i -X DELETE "http://localhost:8080/products/1001"
```

## Beispiel: Kompakter Ablauf (Copy & Paste)
```bash
# Create
curl -s -X POST "http://localhost:8080/products" \
  -H "Content-Type: application/json" \
  -d '{"name":"Keyboard","price":49.99}'

# List
curl -s "http://localhost:8080/products"

# Get (ID ggf. anpassen)
curl -s "http://localhost:8080/products/1001"

# Update (ID ggf. anpassen)
curl -s -X PUT "http://localhost:8080/products/1001" \
  -H "Content-Type: application/json" \
  -d '{"name":"Keyboard Pro","price":79.99}'

# Delete (ID ggf. anpassen)
curl -i -X DELETE "http://localhost:8080/products/1001"
```

## Hinweise / Limitationen (bewusst minimalistisches Beispiel)
- Bei unbekannter ID liefert `GET /products/{id}` aktuell `null` (später typisch: 404).
- `POST` liefert hier ohne `201 Created`/`Location` (später typisch ergänzen).
- Keine Validierung (später z. B. `@Valid` + Constraints).

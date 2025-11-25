package com.ordermanager;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Verantwortlich für das Speichern und Laden von Order-Objekten als JSON-Datei.
 *
 * TODO: Implementieren Sie die Methoden writeOrder(...) und readOrder(...).
 */
public class OrderJsonRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Schreibt das übergebene Order-Objekt als JSON-Datei.
     *
     * @param file  Zieldatei, z. B. "order.json"
     * @param order zu speichernde Bestellung
     */
    public void writeOrder(Path file, Order order) throws IOException {
        // TODO: Order-Objekt in JSON konvertieren und in die Datei schreiben.
    }

    /**
     * Liest eine JSON-Datei und erzeugt daraus ein Order-Objekt.
     *
     * @param file Quelldatei mit JSON-Repräsentation
     * @return eingelesenes Order-Objekt
     */
    public Order readOrder(Path file) throws IOException {
        // TODO: Dateiinhalt lesen und mit ObjectMapper in ein Order-Objekt umwandeln.
        return null; // TODO: durch das eingelesene Objekt ersetzen
    }
}

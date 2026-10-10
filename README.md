# MS-Ordenes

Microservicio encargado de procesar y registrar las compras formales en la tienda.

## Caractersticas
- Recibe las intenciones de compra desde el Frontend.
- **Productor RabbitMQ:** Al crearse una orden, emite el evento orden.creada al exchange otilleria.exchange.
- Se registra en Netflix Eureka.
- Protegido va Microsoft Entra ID (Azure AD).

## Instrucciones de Uso
- Puerto por defecto: 8084
- Ejecutar con mvn spring-boot:run o a travs de docker-compose up.

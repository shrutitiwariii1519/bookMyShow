# bookMyShow
Theatres can upload movie and users can book tickets

**Things missed in code:**
**1. Transactional Scenarios & Design Decisions**
Scenario: Seat booking involves multiple steps (lock seats → create booking → initiate payment → confirm payment → finalize booking).
Design:
Use ACID transactions with @Transactional in Spring Boot for atomicity.
Saga pattern for distributed transactions (e.g., booking + payment across microservices).
Compensation logic: If payment fails, release locked seats.

**2. Integration with Theatres (Existing IT + New)
Existing IT systems:**

Provide REST APIs / GraphQL adapters to integrate with legacy theatre systems.
New theatres:
Offer a self‑service portal with standardized APIs.
Localization:
Use i18n frameworks for UI and locale‑aware search.

**3. Scaling to Multiple Cities & Countries (99.99% Availability)**
Architecture:
Deploy on cloud (AWS/Azure/GCP) with multi‑region clusters
Load balancers for global traffic distribution.
Caching (Redis) for frequently accessed data (movie listings).

4. Integration with Payment Gateways
Design:
Abstract payment layer with Payment Service microservice.

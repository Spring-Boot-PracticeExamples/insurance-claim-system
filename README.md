# 🛡️ Insurance Claim Processing System

This is a **Spring Boot mini-project** that applies all **SOLID principles** using a real-world **Insurance Claim Processing** example. The system supports multiple claim types like `AUTO`, `HEALTH`, and `PROPERTY`.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- REST API
- Gradle
- Lombok

---

## ✅ SOLID Principles Applied

| Principle | Application |
|----------|-------------|
| **S** – Single Responsibility | Each class has a single job (e.g., `ClaimValidator`, `ClaimService`, `ClaimController`) |
| **O** – Open/Closed | New claim types can be added without modifying existing logic |
| **L** – Liskov Substitution | All processors implement the `ClaimProcessor` interface |
| **I** – Interface Segregation | Focused interfaces like `ClaimProcessor` avoid unnecessary methods |
| **D** – Dependency Inversion | `ClaimService` depends on `ClaimProcessor` abstraction, not implementation |

---


Postman Request:
{
"id": "C1001",
"type": "AUTO",
"description": "Accident on highway",
"amount": 2500.0
}


SOLID Principle	Related Class / Interface / Package	Explanation
S – Single Responsibility	- ClaimValidator (validation package)
- ClaimService
- NotificationService
- ClaimProcessor implementations (AutoClaimProcessor, etc.)	Each class has one responsibility, e.g., validation, processing claims, sending notifications
  O – Open/Closed	- ClaimProcessor interface
- ClaimProcessorFactory
- Concrete ClaimProcessor classes	New claim types can be added by creating new processors without modifying existing code
  L – Liskov Substitution	- ClaimProcessor interface
- AutoClaimProcessor, HealthClaimProcessor, etc.	Subclasses implement the interface and can be substituted without breaking functionality
  I – Interface Segregation	- ClaimProcessor interface	The interface is minimal and focused with only the necessary method(s)
  D – Dependency Inversion	- ClaimService depends on ClaimProcessor abstraction
- ClaimProcessorFactory provides processors	High-level modules depend on abstractions, not concrete implementations




















































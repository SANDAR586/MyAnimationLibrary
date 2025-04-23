### File Structure
/app
├── /data                # Data layer (repositories, API, database)
│   ├── /repository      # Data repositories
│   ├── /model           # Data models (entities, network models)
│   └── /api             # API calls (retrofit, networking)
│
├── /domain              # Domain layer (business logic, use cases)
│   ├── /usecase         # Business logic or use cases
│   ├── /model           # Business models, state-related data
│   └── /repository      # Interface for the repository
│
├── /presentation        # UI layer
│   ├── /view            # Activities, Fragments, Composables
│   ├── /viewmodel       # ViewModel (processing Intents, exposing State)
│   ├── /intent          # User Intent definitions
│   └── /state           # State data and ViewState related models
│
└── /di                  # Dependency Injection (Koin modules, etc.)


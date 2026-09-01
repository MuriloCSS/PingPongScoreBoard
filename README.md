| Abordagem                    |      Rotação de Tela       |      Morte do Processo      |
|:-----------------------------|:--------------------------:|:---------------------------:|
| remember                     |       Não sobrevive        |        Não sobrevive        |
| ViewModel + mutableStateOf   |         Sobrevive          |        Não sobrevive        |
| ViewModel + StateFlow        |         Sobrevive          |        Não sobrevive        |
| ViewModel + SavedStateHandle | Sobrevive  | Sobrevive  |
| Abordagem                    |      Rotação de Tela       |      Morte do Processo      |
|:-----------------------------|:--------------------------:|:---------------------------:|
| remember                     |       Não sobrevive        |        Não sobrevive        |
| ViewModel + mutableStateOf   |         Sobrevive          |        Não sobrevive        |
| ViewModel + StateFlow        |         Sobrevive          |        Não sobrevive        |
| ViewModel + SavedStateHandle | Sobrevive  | Sobrevive  |
---
## Respostas das Perguntas

**1. Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do processo, mesmo sobrevivendo à rotação de tela?**
Porque o ViewModel fica guardado na memória RAM do celular. Quando giramos a tela, o Android recria o visual, mas a memória do app continua lá. Porém, quando matamos do processo, o Android encerra o app para liberar memória RAM. Como o ViewModel estava nessa memória, ele é apagado junto.

**2. Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?**
Durante os testes, não teve nenhuma diferença, os dois funcionaram exatamente iguais e zeraram na morte do processo. A diferença é só na hora de escrever o código: o mutableStateOf é uma ferramenta do Jetpack Compose, enquanto o StateFlow é do próprio Kotlin, o que deixa o código mais organizado e menos dependente da tela.

**3. Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que seria necessário adicionar?**
Nenhuma das quatro abordagens daria certo. Para salvar os pontos permanentemente mesmo se o usuário fechar de propósito, seria necessário adicionar um banco de dados, como o Room.

**4. Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?**
Eu usaria a abordagem ViewModel + SavedStateHandle. Seria ruim para o usuário estar no meio de um jogo, minimizar o app para realizar alguma atividade rápida e ao voltar, o placar estar zerado. Essa abordagem resolve esse problema de forma fácil, sem precisar criar um banco de dados só para um placar.
# Wallpaper Search App

Este é um aplicativo Android simples que permite aos usuários pesquisar imagens e definir como papel de parede do dispositivo. O aplicativo foi desenvolvido como parte de um projeto para a disciplina de Desenvolvimento para Dispositivos Móveis em uma faculdade.

## Funcionalidades
O aplicativo possui duas telas principais:

### Tela Principal (MainActivity)
A tela principal apresenta um campo de texto onde o usuário pode inserir um link.
Há um botão de pesquisa que permite iniciar o download com base no termo inserido.
Se o campo de busca estiver vazio e o usuário pressionar o botão de download, será exibida uma mensagem de aviso solicitando que um link seja inserido.
Quando um link é inserido e o botão de donwload é pressionado, o aplicativo passa para a próxima tela (WallpaperActivity) e envia o link parâmetro.

### Tela do Papel de Parede (WallpaperActivity)

A tela do papel de parede exibe uma imagem correspondente ao termo de busca fornecido.
Enquanto a imagem está sendo carregada, uma barra de progresso é exibida.
Após o carregamento da imagem, ela é exibida em um ImageView.
Há um botão "Definir Papel de Parede" que permite ao usuário definir a imagem exibida como papel de parede do dispositivo.
Quando o botão é pressionado, a imagem é obtida do ImageView e é definida como papel de parede usando o WallpaperManager do Android.
Se ocorrer algum erro durante o processo de definição do papel de parede, uma mensagem de erro será exibida.

## Implementação

O aplicativo foi desenvolvido usando a plataforma Android e a linguagem de programação Java. Ele utiliza as seguintes bibliotecas e componentes:

- AppCompatActivity: é uma classe base para atividades do Android que oferece suporte às funcionalidades mais recentes do Android em versões mais antigas.
- Intent: é uma classe que representa uma "intenção" para executar uma ação em um componente do Android, como iniciar uma atividade.
- EditText: é uma caixa de texto onde o usuário pode inserir texto.
- Button: é um botão que pode ser clicado pelo usuário para executar uma ação.
- Toast: é uma pequena mensagem exibida na parte inferior da tela por um curto período de tempo.
- ImageView: é um componente usado para exibir imagens.
- ProgressBar: é uma barra de progresso que indica o progresso de uma tarefa em segundo plano.
- AsyncTask: é uma classe que permite realizar operações em segundo plano e atualizar a interface do usuário durante o processo.
- Glide: é uma biblioteca de carregamento e exibição de imagens que facilita o carregamento de imagens de forma eficiente.

## Como usar o aplicativo
1. Insira um link no campo de texto na tela principal.
2. Pressione o botão de download para iniciar o download.
3. Aguarde enquanto a imagem correspondente ao link é carregada.
4. Quando a imagem é exibida na tela, você pode pressionar o botão "Definir Papel de Parede" para definir a imagem como papel de parede do dispositivo.
5. Se a definição do papel de parede for bem-sucedida, uma mensagem de sucesso será exibida. Caso contrário, uma mensagem de erro será exibida.

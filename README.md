# Minha IA — modelo local no Android

Projeto Android Kotlin/Compose com inferência local usando **Google LiteRT-LM**. Não usa chave de API nem serviço de IA pago. O modelo roda no próprio aparelho depois de baixado.

## Requisitos e limites
- Android Studio recente (recomendado), JDK 17 e Android SDK.
- O projeto usa LiteRT-LM via Maven. Na primeira compilação, a internet é necessária para baixar dependências.
- O arquivo do modelo **não vem incluído** no ZIP: modelos podem ter centenas de MB ou mais e cada modelo tem sua própria licença. Baixe um modelo `.litertlm` compatível de uma fonte confiável, como a coleção LiteRT Community no Hugging Face.
- Para 4 GB de RAM, comece com um modelo pequeno, por exemplo Gemma 3 1B-IT em formato LiteRT-LM se houver uma versão compatível disponível. O desempenho varia; fechar outros apps ajuda. Não escolha modelos grandes.
- A função “Pesquisar na internet” consulta resultados públicos do DuckDuckGo e envia títulos/resumos ao modelo local. Isso exige internet e pode falhar se o site mudar ou bloquear pedidos. O texto da conversa permanece local; a consulta de pesquisa é enviada ao mecanismo de busca.
- O modelo local é bom para conversa e tarefas simples, mas não equivale a uma IA grande na nuvem e não compila APKs sozinho.

## Abrir e gerar APK
1. Extraia o ZIP.
2. Abra a pasta `MinhaIA_Local_Android` no Android Studio.
3. Aguarde o Gradle Sync e aceite instalar os componentes SDK que forem solicitados.
4. No Android Studio, use **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
5. APK de debug: `app/build/outputs/apk/debug/app-debug.apk`.
6. Transfira o APK ao telefone e autorize a instalação dessa fonte, se o Android pedir.

## Colocar o modelo no app
1. Baixe no aparelho um arquivo `.litertlm` compatível com LiteRT-LM. Consulte os modelos suportados e suas licenças na documentação oficial.
2. Abra Minha IA > **Selecionar modelo** e escolha o arquivo no gerenciador de arquivos.
3. Aguarde a cópia para o armazenamento privado do aplicativo.
4. Toque em **Carregar modelo**. O primeiro carregamento pode levar alguns segundos e consumir bastante memória.
5. Envie uma mensagem. Depois de carregar o modelo, o chat funciona sem internet; a pesquisa depende de internet.

## Estrutura
- `MainActivity.kt`: interface, importação de modelo, chat, memória local e pesquisa web simples.
- `AndroidManifest.xml`: permissões de internet e configurações.
- `app/build.gradle.kts`: dependências.

## Importante
Este é um projeto-fonte inicial e não foi compilado nem testado neste ambiente. A API e a disponibilidade de modelos podem mudar; se o Gradle apontar incompatibilidade, confira a versão mais recente da documentação LiteRT-LM. Nenhum APK pré-compilado está incluído.


## Gerar o APK gratuitamente pela nuvem (GitHub Actions)
Este repositório inclui `.github/workflows/build-apk.yml`.
1. Crie uma conta no GitHub e um repositório vazio chamado `MinhaIA`.
2. Envie todos os arquivos desta pasta para a branch `main` (incluindo a pasta oculta `.github`).
3. Abra a aba **Actions**, selecione **Build Minha IA APK** e clique em **Run workflow**.
4. Quando terminar, abra a execução concluída e baixe o artefato **MinhaIA-debug-apk**.
5. Extraia o artefato para obter `app-debug.apk`.

A compilação na nuvem é uma tentativa automatizada; não equivale a dizer que o APK já foi compilado ou testado. Se houver erro de build, abra a execução e leia o log do Gradle.

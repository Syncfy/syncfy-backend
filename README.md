# Syncfy - Plataforma de Solicitação e Cotações

## Link para o Vídeo de apresentação do Backend da Plataforma

https://youtu.be/N2igslpiDX8

## Link para o Vídeo de apresentação do Deploy da plataforma na Azure como App Service

https://fiapcom-my.sharepoint.com/:v:/g/personal/rm96920_fiap_com_br/Ec-aWcQZLNNCtV1xbxdc2HgBdRZSuqF_R5HGF_0JvWassA?e=artaBh

## Apresentação da Equipe

A equipe do Syncfy é composta por experientes no desenvolvimento de soluções B2B. Nossos membros incluem:

- Matheus Ramos de Pierro - Arquiteto e Dev FullStack - https://github.com/matheusPierro/
- Felipe de Lima Santiago - Scrum Master - https://github.com/fehstack
- Gabriel Tricerri André Niacaris - Dev FullStack - https://github.com/gabriel-tricerri
- Victor Shimada - Desenvolvedor Mobile - https://github.com/shimarrudz
- Thiago Gyorgy Teixeira de Castro - Dev FullStack - https://github.com/ThiCastroo/

# Sumário

[Estudo de caso ](#_Estudo_de_caso)

[Fluxograma da arquitetura do Sistema](#_fluxograma_)

[Fluxograma de comunicação do Sistema](#_comunicacao_)

[Diagrama de Entidades e Relacionamentos ](#_der_)

[Modelo de Entidades e Relacionamentos ](#_mer_)

[Diagrama de Classes ](#_Diagrama_de_Classes)

[Como rodar a aplicação](#_Rodar_Aplicacao)

[Pitch](#_pitch)

<a id="_Estudo_de_caso"></a>

# Estudo de caso

### Como o Syncfy Revolucionou o Processo de Aquisição de Produtos para Empresas

## Introdução

Uma solução B2B inovadora para solicitações de cotações de compra de produtos, transformou a maneira como as empresas adquirem produtos e serviços. A Syncfy se destaca por sua busca incessante pela precisão e eficiência, visando alcançar uma taxa de 100% de matching entre as solicitações das empresas e as cotações fornecidas pelos fornecedores.

## O Desafio

Antes de adotar o Syncfy, as empresas enfrentavam diversos desafios ao adquirir produtos, incluindo:

1. Ineficiência no processo de solicitação de cotações.
2. Erros de comunicação que levavam a cotações imprecisas.
3. Falta de transparência e rastreabilidade nas solicitações de cotação.
4. Tempo gasto excessivo na correspondência manual com fornecedores.

Esses desafios resultaram em atrasos, custos excessivos e insatisfação entre as empresas que buscavam otimizar suas operações de aquisição.

## A Solução

A Syncfy introduziu uma plataforma B2B revolucionária que abordou esses desafios de frente. Sua abordagem envolveu:

1. **Solicitações Precisas**: A plataforma permitiu que as empresas especificassem detalhes precisos de suas necessidades, eliminando mal-entendidos e erros nas solicitações.

2. **Match 100%**: A Syncfy desenvolveu algoritmos sofisticados que garantem que as cotações fornecidas pelos fornecedores atendam exatamente às especificações das empresas.

3. **Comunicação Eficiente**: A plataforma automatizou a comunicação entre as empresas e os fornecedores, garantindo que todas as informações relevantes fossem compartilhadas de maneira eficiente e segura.

## Resultados

A implementação do Syncfy terá um impacto notável nas empresas que adotaram a plataforma:

1. **Eficiência Aprimorada**: O tempo gasto no processo de aquisição foi reduzido significativamente, permitindo que as empresas alocassem recursos para outras áreas críticas de negócios.

2. **Redução de Erros**: A taxa de erro nas cotações foi virtualmente eliminada, economizando tempo e recursos anteriormente desperdiçados na correção de discrepâncias.

3. **Satisfação do Cliente**: As empresas puderam atender às necessidades de seus clientes de forma mais eficaz devido à capacidade de obter cotações precisas e prontas.

4. **Economia de Custos**: A redução de erros e a eficiência aprimorada resultaram em economias significativas de custos de aquisição.

Impacto Financeiro:

Eficiência Operacional: O Syncfy é projetado para melhorar a eficiência operacional, reduzindo redundâncias e automatizando processos. Isso resultará em uma otimização de recursos e, por conseguinte, em redução de custos operacionais.

Tomada de Decisão Informada: Com dados centralizados e relatórios em tempo real, o Syncfy capacita a tomada de decisões mais informadas. Isso pode levar a escolhas estratégicas que impactam positivamente os resultados financeiros.

Experiência do Cliente: Melhorar a gestão de pedidos, estoques e fornecedores resultará em uma experiência do cliente aprimorada. A satisfação do cliente pode, por sua vez, impulsionar a lealdade e as receitas.

Escalabilidade: O Syncfy é escalável, o que significa que o sistema pode crescer junto com a empresa. Isso proporciona flexibilidade para expansão e acomodação de futuras demandas sem custos significativos adicionais.

Investimento Necessário:

Licenças e Implementação do Software: O investimento inicial incluirá a aquisição de licenças do Syncfy e os custos associados à implementação do software. Isso abrange a configuração inicial, treinamento da equipe e personalizações necessárias.

Infraestrutura Tecnológica: Certifique-se de que a infraestrutura existente atenda aos requisitos do Syncfy. Pode ser necessário investir em hardware adicional, atualizações de servidores ou ajustes na rede para garantir um desempenho otimizado.

Manutenção e Suporte Contínuos: Considere os custos associados à manutenção contínua do sistema, incluindo atualizações de software, suporte técnico e possíveis custos de integração com outros sistemas.

## Conclusão

O projeto Syncfy ilustra como a inovação tecnológica pode simplificar processos de aquisição complexos. Ao focar na precisão e na eficiência, a plataforma ajudou as empresas a otimizar suas operações de aquisição, economizando tempo e recursos valiosos. A busca por um matching de 100% nas cotações demonstra o compromisso contínuo da Syncfy em atender às necessidades de seus clientes e melhorar constantemente a eficiência dos processos de aquisição.

<a id="_fluxograma_"></a>

# Fluxograma da Arquitetura do Sistema

<img src="./documentacao/Enterprise%20Application%20Development/FluxogramaArquiteturaDoSistema.png" title="Fluxograma da Arquitetura do Sistema">

<a id="_comunicacao_"></a>

# Fluxograma da Arquitetura de Recursos do Sistema e Comunicação

<img src="./documentacao/DevOps%20Tools%20e%20Cloud%20Computing/Sprint3/arquiteturaSolucao.png" title="Fluxograma da Arquitetura do Sistema">

### Descritivo

1. Os usuários acessam nosso aplicativo feito React Native.
2. Utilizando o Firebase como base de dados para manipulação de dados de acesso e sessão.
3. Os serviços oferecidos pela Syncfy, incluem Python com Flask para o processo de matching em http requests.
4. As informações são armazenadas no banco de dados da plataforma Pipefy.
5. Pipefy é onde nosso backend trabalha além de oferecer uma base de dados consistente.
6. A mesma fornece dashboards e metricas para melhora continua de serviços.

<a id="_der_"></a>

# Diagrama de Entidades e Relacionamentos

<img src="./documentacao/Enterprise%20Application%20Development/ML_Syncfy.png" title="Fluxograma da Arquitetura do Sistema">

<a id="_mer_"></a>

# Modelo de Entidades e Relacionamentos

<img src="./documentacao/Enterprise%20Application%20Development/MR_Syncfy.png" title="Fluxograma da Arquitetura do Sistema">

<a id="_Diagrama_de_Classes"></a>

# Diagrama de Classes

<img src="./documentacao/Enterprise%20Application%20Development/diagrama_classes.png" title="Diagrama de Classes">

<a id="_Rodar_Aplicacao"></a>

# Como rodar a aplicação

Observação: Caso não queira fazer o deploy da aplicação na nuvem e apenas rodar o backend localmente na sua maquina, pule os primeiros passos.

Será necessário seguir os passos abaixo:

### Para o deploy

1. **Dentro do pom.xml fazer as devidas configurações de sua máquina azure**

            <plugin>
                <groupId>com.microsoft.azure</groupId>
                <artifactId>azure-webapp-maven-plugin</artifactId>
                <version>2.9.0</version>
                <configuration>
                    <resourceGroup>syncfy-rg</resourceGroup>
                    <appName>syncfy-app-service</appName>
                    <pricingTier>F1</pricingTier>
                    <region>brazilsouth</region>
                    <runtime>
                        <os>Linux</os>
                        <webContainer>Java SE</webContainer>
                        <javaVersion>Java 17</javaVersion>
                    </runtime>
                    <deployment>
                        <resources>
                            <resource>
                                <type>jar</type>
                                <directory>${project.basedir}/target</directory>
                                <includes>
                                    <include>*.jar</include>
                                </includes>
                            </resource>
                        </resources>
                    </deployment>
                </configuration>
            </plugin>
   
Se achar interessante, também é possível configurar sua máquina por linha de comando com o comando maven:

mvn com.microsoft.azure:azure-webapp-maven-plugin:2.9.0:config 

2. **Deploy da aplicação através do maven do projeto:**

mvn package azure-webapp:deploy

Ele irá solicitar login na sua conta azure com a sua licença e então fará a criação da máquina em sua conta.

é importante ressaltar a possibilidade de estourar o limite de sessões no banco oracle e então seria necessário configurar novos usuários para a aplicação. Segue a seguir usuarios e senhas para teste:

- Usuario: rm96920 Senha: 080903
- Usuario: rm97121 Senha: 290603
- Usuario: rm97097 Senha: 220104

Ponto de atenção: Verifique se o nome de sua máquina já não existe, se não pode acabar dando erro no deploy da aplicação na azure.

### Para rodar a aplicação localmente

1. **Build do projeto**: Através do maven abra o projeto e execute o seguinte comando:

mvn clean install -DskipTests -U

Assim ele irá buildar o projeto pulando as etapas de testes e forçando atualizações necessárias.

2. **Encontrar arquivo .jar (lib) do projeto**:
   Após o build do projeto se tudo ocorrer bem esperamos encontrar um arquivo .jar do projeto dentro da pasta target do projeto (A mesma foi criada logo após o build).

/target/syncfy-0.0.1-SNAPSHOT.jar

3. **Rodar aplicação através da lib**: Agora que temos nossa lib(arquivo .jar do nosso projeto) podemos rodar a aplicação com o seguinte comando:

java -jar target/syncfy-0.0.1-SNAPSHOT.jar

p.s. é necessário ter a jdk versão 17 instalada em sua máquina ou podem acontecer erros de versão.

<a id="_endpoints"></a>

### Endpoints para testar a aplicação rodando:

Dentro da pasta ./documentacao/postman/ existe uma collection com 5 apis formando um crud completo para Company e utilizando paginação simples para testes(não precisamos usar sort ou limite de tamanho)

## Arquitetura Pipeline

<img src="./documentacao/DevOps%Tools%e%Cloud%Computing/ArquiteturaPipeline.jpg" title="Arquitetura Pipeline">

### Execução da Pipeline CI/CD no Azure**

#### 1. Acesso ao Azure DevOps:

Acesse o <a href="https://dev.azure.com/SyncfyDevops/">Azure DevOps</a> usando suas credenciais.

#### 2. Seleção da Organização e Projeto:

Na página inicial do Azure DevOps, selecione a sua organização "SyncfyDevops" e o projeto "Syncfy".

#### 3. Acesso à Pipeline:

No menu lateral do projeto, clique em "Pipelines".
Você deve ver a lista de pipelines disponíveis. Localize a pipeline chamada "Syncfy-Maven-CI" e clique nela para acessá-la.

#### 4. Execução da Pipeline:

Na página da pipeline, você deve encontrar um botão "Run" ou "Run pipeline" (dependendo da interface do usuário do Azure DevOps que está sendo usada).
Clique neste botão para iniciar a execução da pipeline.

#### 5. Monitoramento:

Durante a execução da pipeline, você pode monitorar o progresso e verificar os logs para depuração, se necessário.
Após a conclusão da execução, verifique se todas as etapas foram concluídas com sucesso.

#### 6. Acesse a aplicação Web:

Abra um navegador da web e vá para o seguinte endereço: app-syncfy.azurewebsites.net.
Isso deve direcioná-lo para a página inicial da sua aplicação Spring MVC implantada no Azure App Service.
Verifique se a aplicação está funcionando conforme o esperado, realizando algumas operações básicas para garantir que tudo esteja em ordem.

<a id="_pitch"></a>

## Para mais detalhes assista ao nosso Picth:

[![Alt text](https://img.youtube.com/vi/iyOTlpfnWXU/0.jpg)](https://www.youtube.com/watch?v=iyOTlpfnWXU)

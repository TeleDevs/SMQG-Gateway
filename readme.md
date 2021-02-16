# SMQG-Gateway


## Configuração de acesso a rasp SSH via WiFi

Após instalar a imagem:

Dentro da partição `boot` criada no cartão SD:

  - Criar um arquivo chamado `wpa_supplicant.conf`, com o seguinte conteúdo:

```
ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
update_config=1
country=BR

network={
ssid="<Nome da sua rede>"
psk="<Senha da sua rede>"
}
```
- Criar um arquivo vazio chamado `ssh`. Note que o arquivo não contém extensão. 

Neste ponto já possível acessar remotamente a Raspberry Pi. 

```
~$ ssh pi@IP_DA_RASP
~$ password: raspberry
```

---

## Configurando Gateway

- Passo a passo para configuração de um Gateway LoRa (RHF0M301) usando The Things Network: [aqui](https://github.com/mftutui/configuracoes-gateway-ttn)

---

## Gateway registrado na TTN:
- [B827EBFFFF46EC6D.json](https://github.com/PavelKutilek/gateway-remote-config-1/blob/master/B827EBFFFF46EC6D.json)

---

# ⚠️ Erros durante o projeto

## ERRO 01

```console
ttn@raspberrypi:~ $ sudo systemctl status gateway -l
● gateway.service - TTN Gateway Service
   Loaded: loaded (/etc/systemd/system/gateway.service; enabled; vendor preset: enabled)
   Active: activating (auto-restart) (Result: exit-code) since Tue 2021-02-16 11:16:42 -03; 9s ago
  Process: 722 ExecStartPre=/opt/lora_gateway/reset_lgw.sh start (code=exited, status=0/SUCCESS)
  Process: 728 ExecStart=/opt/packet_forwarder/lora_pkt_fwd/lora_pkt_fwd (code=exited, status=1/FAILURE)
 Main PID: 728 (code=exited, status=1/FAILURE)

Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: INFO: local_conf.json does contain a JSON object named gateway_conf, parsing gateway parameters
Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: INFO: gateway MAC address is configured to B827EBFFFF46EC6D
Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: INFO: packets received with a valid CRC will be forwarded
Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: INFO: packets received with a CRC error will NOT be forwarded
Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: INFO: packets received with no CRC will NOT be forwarded
Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: ERROR: Failed to load fw 1
Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: ERROR: Version of calibration firmware not expected, actual:0 expected:2
Feb 16 11:16:42 raspberrypi lora_pkt_fwd[728]: ERROR: [main] failed to start the concentrator
Feb 16 11:16:42 raspberrypi systemd[1]: gateway.service: Main process exited, code=exited, status=1/FAILURE
Feb 16 11:16:42 raspberrypi systemd[1]: gateway.service: Failed with result 'exit-code'.
```

Tópicos com possíveis soluções:

- [util_pkt_logger: ERROR failed to load fw 1? #50](https://github.com/Lora-net/lora_gateway/issues/50)
- [Failed to load fw 1 #96](https://github.com/Lora-net/lora_gateway/issues/96)
- [ERROR: Version of calibration firmware not expected, actual:66 expected:2 #94](https://github.com/Lora-net/lora_gateway/issues/94)

> Talvez seja algum problema de alimentação.

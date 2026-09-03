package ru.metaculture.protection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class BotCommand extends ChatCommand {
   public BotCommand() {
      super(
         "bot",
         "Headless bot management",
         ".bot connect <nick> <ip[:port]> | remove | chat | control <nick> | return | list | clear"
      );
      this.primaryVal("connect", List::of);
      this.primaryVal("remove", () -> HeadlessBotHostManager.secondaryVal().stream().map(HeadlessBotHostManager.WildClient::name).collect(Collectors.toList()));
      this.primaryVal("chat", () -> HeadlessBotHostManager.primaryVal.stream().map(HeadlessBotSession::primaryVal).collect(Collectors.toList()));
      this.primaryVal("control", () -> HeadlessBotHostManager.primaryVal.stream().map(HeadlessBotSession::primaryVal).collect(Collectors.toList()));
      this.primaryVal("return", List::of);
      this.primaryVal("list", List::of);
      this.primaryVal("clear", List::of);
   }

   @Override
   public void secondaryVal(String[] var1) {
      if (var1.length != 0 && !var1[0].equalsIgnoreCase("help")) {
         switch (var1[0].toLowerCase()) {
            case "connect":
               if (var1.length < 3) {
                  ChatLogger.primaryVal(
                     "§c[Bot] Usage: .bot connect <nick> <ip[:port] or domain>"
                  );
                  return;
               }

               BotConnector.primaryVal(var1[1], var1[2]);
               break;
            case "remove":
               if (var1.length < 2) {
                  ChatLogger.primaryVal(
                     "§c[Bot] Usage: .bot remove <nick>"
                  );
                  return;
               }

               HeadlessBotHostManager.WildClient var7 = HeadlessBotHostManager.primaryVal(var1[1]);
               if (var7 == null) {
                  ChatLogger.primaryVal("§c[Bot] Bot not found: " + var1[1]);
                  return;
               }

               if (!HeadlessBotHostManager.tertiaryVal(var1[1])) {
                  ChatLogger.primaryVal(
                     "§7[Bot] Profile is already disconnected: §f"
                        + var7.name()
                  );
                  return;
               }

               ChatLogger.primaryVal("§7[Bot] §fDisconnected §c" + var7.name());
               break;
            case "chat":
               if (var1.length < 3) {
                  ChatLogger.primaryVal(
                     "§c[Bot] Usage: .bot chat <nick> <text>"
                  );
                  return;
               }

               HeadlessBotSession var6 = HeadlessBotHostManager.extraVal(var1[1]);
               if (var6 == null) {
                  ChatLogger.primaryVal("§c[Bot] Bot not found: " + var1[1]);
                  return;
               }

               String var5 = String.join(" ", Arrays.copyOfRange(var1, 2, var1.length));
               if (!var6.primaryVal(var5)) {
                  ChatLogger.primaryVal(
                     "§c[Bot] Bot hasn't logged in yet, is disconnected, or the message is empty/longer than 256 characters"
                  );
                  return;
               }

               ChatLogger.primaryVal("§7[Bot §a" + var6.primaryVal() + "\u00a77] \u00a78\u2192 \u00a7f" + var5);
               break;
            case "list":
               if (HeadlessBotHostManager.secondaryVal().isEmpty()) {
                  ChatLogger.primaryVal("§7[Bot] No bots");
                  return;
               }

               ChatLogger.primaryVal(
                  "§7[Bot] Profiles: §f"
                     + HeadlessBotHostManager.secondaryVal()
                        .stream()
                        .map(var0 -> var0.name() + " \u00a78[" + var0.state().name().toLowerCase() + "\u00a78]\u00a7f")
                        .collect(Collectors.joining(", "))
               );
               break;
            case "control":
               if (var1.length < 2) {
                  ChatLogger.primaryVal(
                     "§c[Bot] Usage: .bot control <nick>"
                  );
                  return;
               }

               HeadlessBotSession var4 = HeadlessBotHostManager.extraVal(var1[1]);
               if (var4 == null || !var4.widthVal()) {
                  ChatLogger.primaryVal(
                     "§c[Bot] Bot not found or hasn't joined yet: "
                        + var1[1]
                  );
                  return;
               }

               if (!HeadlessBotHostManager.primaryVal(var4)) {
                  ChatLogger.primaryVal(
                     "§c[Bot] Cannot switch control right now: check the host's connection and wait for the server switch to complete"
                  );
                  return;
               }

               ChatLogger.primaryVal(
                  "§7[Bot] Control §a"
                     + var1[1]
                     + "§7. Return yourself: §f.bot return"
               );
               break;
            case "return":
               HeadlessBotHostManager.marginVal();
               ChatLogger.primaryVal(
                  "§7[Bot] Control returned to host"
               );
               break;
            case "clear":
               HeadlessBotHostManager.timerVal();
               ChatLogger.primaryVal("§7[Bot] All bots disconnected");
               break;
            default:
               ChatLogger.primaryVal(
                  "§c[Bot] Unknown subcommand: §f"
                     + var1[0]
                     + " §7— see §f.bot"
               );
         }
      } else {
         ChatLogger.primaryVal("§7[Bot] Commands:");
         ChatLogger.primaryVal(
            "  §f.bot connect §7<nick> <ip[:port]/domain> §8— connect a bot"
         );
         ChatLogger.primaryVal(
            "  §f.bot control §7<nick> §8— possess a bot (control)"
         );
         ChatLogger.primaryVal(
            "  §f.bot return §8— return to host"
         );
         ChatLogger.primaryVal(
            "  §f.bot chat §7<nick> <text> §8— send a chat message as the bot"
         );
         ChatLogger.primaryVal("  §f.bot list §8— list bots");
         ChatLogger.primaryVal(
            "  §f.bot remove §7<nick> §8— disconnect a bot"
         );
         ChatLogger.primaryVal("  §f.bot clear §8— disconnect all");
         ChatLogger.primaryVal(
            "§8Bot manager and modules — Bots tab in the ClickGUI sidebar."
         );
      }
   }
}

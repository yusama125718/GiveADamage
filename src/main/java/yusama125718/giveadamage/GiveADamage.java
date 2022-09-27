package yusama125718.giveadamage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

import static java.lang.Integer.decode;
import static java.lang.Integer.parseInt;

public final class GiveADamage extends JavaPlugin {

    @Override
    public void onEnable() {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!sender.hasPermission("mdamage.op")) return true;
        if (args.length == 2) {
            Player target;
            try {
                target = Bukkit.getPlayer(args[0]);
            } catch (NullPointerException e) {
                sender.sendMessage("[GiveADamage]そのプレイヤーは存在しません");
                return true;
            }
            boolean isNumeric = args[1].matches("-?\\d+");
            if (!isNumeric) {
                sender.sendMessage("§l[§e§lMan10Dice§f§l]§r§c§lダイスの面数は1以上の整数にしてください");
                return true;
            }
            if (args[1].length() >= 10) {
                sender.sendMessage("§l[§e§lMan10Dice§f§l]§r§c§lダイスの面数は10億以上に設定できません");
                return true;
            }
            int damage = parseInt(args[1]);
            if (damage <= 1) {
                sender.sendMessage("[GiveADamage]ダメージ量は1以上の整数にしてください");
                return true;
            }
            target.damage(damage);
            return true;
        }
        else {
            sender.sendMessage("[GiveADamage]/damage [対象] [ダメージ量]");
            return true;
        }
    }

    @Override
    public void onDisable() {}
}

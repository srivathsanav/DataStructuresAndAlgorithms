import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ValidIpAddress {
    public static ArrayList<String> restoreIpAddresses(String ipAddress) {
        Set<String> allValidIpAddress = new HashSet<>();

        for (int firstIndex = 0; firstIndex < 3 && firstIndex < ipAddress.length() ; firstIndex++) {
            StringBuilder currentIpAddress = new StringBuilder();
            String firstPart = ipAddress.substring(0, firstIndex + 1);
            if (!isValidIPAddress(firstPart)) {
                break;
            }
            for (int secondIndex = firstIndex + 1; secondIndex < firstIndex + 4 && secondIndex < ipAddress.length(); secondIndex++) {
                String secondPart = ipAddress.substring(firstIndex + 1, secondIndex + 1);
                if (!isValidIPAddress(secondPart)) {
                    break;
                }
                for (int thirdIndex = secondIndex + 1; thirdIndex < secondIndex + 4 && thirdIndex < ipAddress.length(); thirdIndex++) {
                    String thirdPart = ipAddress.substring(secondIndex + 1, thirdIndex + 1);
                    if (!isValidIPAddress(thirdPart)) {
                        break;
                    }
                    for (int fourthIndex = thirdIndex + 1; fourthIndex < thirdIndex + 4 && fourthIndex < ipAddress.length(); fourthIndex++) {
                        String foruthPart = ipAddress.substring(thirdIndex + 1, ipAddress.length());
                        if (!isValidIPAddress(foruthPart)) {
                            break;
                        }

                        currentIpAddress.append(firstPart).append(".")
                                .append(secondPart).append(".").append(thirdPart).append(".").append(foruthPart);
                        allValidIpAddress.add(currentIpAddress.toString());
                        currentIpAddress = new StringBuilder();
                    }
                }
            }
        }
        return new ArrayList<>(allValidIpAddress);
    }

    private static boolean isValidIPAddress(String ipAddress) {
        if (ipAddress.length() > 3 || ipAddress.length() < 1) {
            return false;
        }
        if (ipAddress.length() > 1 && ipAddress.charAt(0) == '0') {
            return false;
        }
        Integer ip = Integer.parseInt(ipAddress);

        if (ip >=0 && ip <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("19216811"));
    }
}

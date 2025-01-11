package BM85_验证IP地址.java_solutions;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases for IPv4
        System.out.println("Test Case: 172.16.254.1");
        System.out.println(solution.solve("172.16.254.1").equals("IPv4") ? "Passed" : "Failed");

        System.out.println("Test Case: 192.168.1.1");
        System.out.println(solution.solve("192.168.1.1").equals("IPv4") ? "Passed" : "Failed");

        System.out.println("Test Case: 255.255.255.255");
        System.out.println(solution.solve("255.255.255.255").equals("IPv4") ? "Passed" : "Failed");

        System.out.println("Test Case: 0.0.0.0");
        System.out.println(solution.solve("0.0.0.0").equals("IPv4") ? "Passed" : "Failed");

        System.out.println("Test Case: 172.16.254.01");
        System.out.println(solution.solve("172.16.254.01").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: 172.300.254.1");
        System.out.println(solution.solve("172.300.254.1").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: 172.16.254");
        System.out.println(solution.solve("172.16.254").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: 172..254.1");
        System.out.println(solution.solve("172..254.1").equals("Neither") ? "Passed" : "Failed");

        // Test cases for IPv6
        System.out.println("Test Case: 2001:0db8:85a3:0000:0000:8a2e:0370:7334");
        System.out.println(solution.solve("2001:0db8:85a3:0000:0000:8a2e:0370:7334").equals("IPv6") ? "Passed" : "Failed");

        System.out.println("Test Case: 2001:db8:85a3:0:0:8A2E:0370:7334");
        System.out.println(solution.solve("2001:db8:85a3:0:0:8A2E:0370:7334").equals("IPv6") ? "Passed" : "Failed");

        System.out.println("Test Case: 2001:db8:85a3::8A2E:0370:7334");
        System.out.println(solution.solve("2001:db8:85a3::8A2E:0370:7334").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: 02001:0db8:85a3:0000:0000:8a2e:0370:7334");
        System.out.println(solution.solve("02001:0db8:85a3:0000:0000:8a2e:0370:7334").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: 2001:abcd:efgh:ijkl::aaaa:bbbb:cccc");
        System.out.println(solution.solve("2001:abcd:efgh:ijkl::aaaa:bbbb:cccc").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: 2001:0db8:85a3:0000:0000:8a2e:0370");
        System.out.println(solution.solve("2001:0db8:85a3:0000:0000:8a2e:0370").equals("Neither") ? "Passed" : "Failed");

        // Test cases for invalid inputs
        System.out.println("Test Case: not.an.ip.address");
        System.out.println(solution.solve("not.an.ip.address").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: 1234::5678");
        System.out.println(solution.solve("1234::5678").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: ::");
        System.out.println(solution.solve("::").equals("Neither") ? "Passed" : "Failed");

        System.out.println("Test Case: ::1");
        System.out.println(solution.solve("::1").equals("Neither") ? "Passed" : "Failed");
    }
}

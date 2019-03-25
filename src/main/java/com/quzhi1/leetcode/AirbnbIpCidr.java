package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AirbnbIpCidr {

  private static long ipToLong(String strIP) {
    long[] ip = new long[4];
    String[] ipSec = strIP.split("\\.");
    for (int k = 0; k < 4; k++) {
      ip[k] = Long.valueOf(ipSec[k]);
    }
    return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
  }

  private static String longToIP(long longIP) {
    StringBuffer sb = new StringBuffer();
    sb.append(longIP >>> 24);
    sb.append(".");
    sb.append((longIP & 0x00FFFFFF) >>> 16);
    sb.append(".");
    sb.append((longIP & 0x0000FFFF) >>> 8);
    sb.append(".");
    sb.append(longIP & 0x000000FF);
    return sb.toString();
  }

  public static List<String> ipRange2Cidr(String startIp, int range) {
    // check parameters
    long start = ipToLong(startIp);
    long end = start + range - 1;
    List<String> res = new ArrayList<>();
    while (start <= end) {
      // identify the location of first 1's from lower bit to higher bit of start IP
      // e.g. 00000001.00000001.00000001.01101100, return 4 (100)
      long locOfFirstOne = start & (-start);
      int curMask = 32 - (int) (Math.log(locOfFirstOne) / Math.log(2));
      // calculate how many IP addresses between the start and end
      // e.g. between 1.1.1.111 and 1.1.1.120, there are 10 IP address
      // 3 bits to represent 8 IPs, from 1.1.1.112 to 1.1.1.119 (119 - 112 + 1 = 8)
      double currRange = Math.log(end - start + 1) / Math.log(2);
      int currRangeMask = 32 - (int) Math.floor(currRange);
      // why max?
      // if the currRangeMask is larger than curMask
      // which means the numbers of IPs from start to end is smaller than mask range
      // so we can't use as many as bits we want to mask the start IP to avoid exceed the end IP
      // Otherwise, if currRangeMask is smaller than curMask, which means number of IPs is larger than mask range
      // in this case we can use curMask to mask as many as IPs from start we want.
      curMask = Math.max(currRangeMask, curMask);
      // Add to results
      String ip = longToIP(start);
      res.add(ip + "/" + curMask);
      // We have already included 2^(32 - curMask) numbers of IP into result
      // So the next roundUp start must insert that number
      start += Math.pow(2, (32 - curMask));
    }
    return res;
  }

  public static void main(String[] args) {
    List<String> result = ipRange2Cidr("0.0.0.111", 4);
    System.out.println(String.join(", ", result));
  }

}

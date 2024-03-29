/*
授权声明：
本源码系《Java多线程编程实战指南（核心篇）》一书（ISBN：978-7-121-31065-2，以下称之为“原书”）的配套源码，
欲了解本代码的更多细节，请参考原书。
本代码仅为原书的配套说明之用，并不附带任何承诺（如质量保证和收益）。
以任何形式将本代码之部分或者全部用于营利性用途需经版权人书面同意。
将本代码之部分或者全部用于非营利性用途需要在代码中保留本声明。
任何对本代码的修改需在代码中以注释的形式注明修改人、修改时间以及修改内容。
本代码可以从以下网址下载：
https://github.com/Viscent/javamtia
http://www.broadview.com.cn/31065
*/
package com.guo.ch3.case01;


import com.guo.util.ReadOnlyIterator;

import java.util.Iterator;
import java.util.Set;

public final class Candidate implements Iterable<Endpoint> {
  // 下游部件节点列表
  private final Set<Endpoint> endpoints;
  // 下游部件节点的总权重
  public final int totalWeight;

  public Candidate(Set<Endpoint> endpoints) {
    int sum = 0;
    for (Endpoint endpoint : endpoints) {
      sum += endpoint.weight;
    }
    this.totalWeight = sum;
    this.endpoints = endpoints;
  }

  public int getEndpointCount() {
    return endpoints.size();
  }

  @Override
  public final Iterator<Endpoint> iterator() {
    return ReadOnlyIterator.with(endpoints.iterator());
  }

  @Override
  public String toString() {
    return "Candidate [endpoints=" + endpoints + ", totalWeight=" + totalWeight
        + "]";
  }
}
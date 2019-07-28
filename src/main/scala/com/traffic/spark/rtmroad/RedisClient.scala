package com.traffic.spark.rtmroad

import org.apache.commons.pool2.impl.GenericObjectPoolConfig
import redis.clients.jedis.JedisPool

object RedisClient {
  val redisHost = "node01"
  val redisPort = 6379
  val redisTimeout = 30000

  val pool = new JedisPool(new GenericObjectPoolConfig(), redisHost, redisPort, redisTimeout)
}

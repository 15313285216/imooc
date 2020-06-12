package com.imooc.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HelloServerTest {

	public static void main(String[] args) throws InterruptedException {
		
		//创建主从线程
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap bootStrap = new ServerBootstrap();
			bootStrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new HelloHandlerInit());
			ChannelFuture channelFuture = bootStrap.bind(8088).sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}

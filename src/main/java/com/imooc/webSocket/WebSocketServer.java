package com.imooc.webSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebSocketServer {

	public static void main(String[] args) throws Exception {
		
		EventLoopGroup mainGroup = new NioEventLoopGroup();
		EventLoopGroup subGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(mainGroup,subGroup).channel(NioServerSocketChannel.class).childHandler(new ChatChannelInit());
			ChannelFuture channelFuture = bootstrap.bind(8088).sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			mainGroup.shutdownGracefully();
			subGroup.shutdownGracefully();
		}
		
	}
}

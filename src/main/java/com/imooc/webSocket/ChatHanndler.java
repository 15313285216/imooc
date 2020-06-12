package com.imooc.webSocket;

import java.time.LocalDateTime;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChatHanndler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
	//用来管理所有客户端的channel
	private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		String content = msg.text();
		System.out.println("接收到的数据：" + content);
		
		group.writeAndFlush(new TextWebSocketFrame("[服务器在]"+LocalDateTime.now()+"接受的消息，消息为："+content));
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		group.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端断开，channel的长度：" + ctx.channel().id().asLongText());
		System.out.println("客户端断开，channel的长度：" + ctx.channel().id().asShortText());
	}

}

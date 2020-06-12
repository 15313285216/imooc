package com.imooc.webSocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class ChatChannelInit extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("HttpServerCodec",new HttpServerCodec());
		//对写大数据流的支持
		pipeline.addLast("ChunkedWriteHandler",new ChunkedWriteHandler());
		//聚合器  聚合httpRequst和httpResponse
		pipeline.addLast("HttpObjectAggregator",new HttpObjectAggregator(1024*64));
		//用于给客户点指定访问的路由：/ws
		pipeline.addLast("WebSocketServerProtocolHandler",new WebSocketServerProtocolHandler("/ws"));
		
		pipeline.addLast("ChatHanndler",new ChatHanndler());
	}

}

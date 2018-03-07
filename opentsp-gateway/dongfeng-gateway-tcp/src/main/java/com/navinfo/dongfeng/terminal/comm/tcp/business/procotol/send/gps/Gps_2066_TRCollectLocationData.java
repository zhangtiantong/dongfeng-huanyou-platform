package com.navinfo.dongfeng.terminal.comm.tcp.business.procotol.send.gps;

import com.navinfo.dongfeng.terminal.comm.common.Command;
import com.navinfo.dongfeng.terminal.comm.common.Packet;
import com.navinfo.dongfeng.terminal.comm.common.constant.Constant;
import org.springframework.stereotype.Component;

/****
 * 采集指定的位置信息记录
 * 消息回复采集指定的位置信息记录应答
 * @author Administrator
 *
 */
@Component
public class Gps_2066_TRCollectLocationData extends Command {

	@Override
	public Object processor(Packet packet) {
		try {
			packet.setMsgType(Constant.GPS_MESSAGE_TYPE);
			sendMsgToCloud(packet, "采集指定的位置信息记录");
		} catch (Exception e) {
			log.error("采集指定的位置信息记录异常", e);
		}
		return null;
	}


}

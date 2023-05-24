import { ShortUserModel } from "./user.model";

export class ShortDialog {
  id: string;
  user: ShortUserModel;
  lastMessage: string;

  constructor(source: any) {
    this.id = source.id;
    this.user = source.user;
    this.lastMessage = source.lastMessage;
  }
}

export class ChatMessage {
  id: string;
  sentAt: string;
  content: string;
  sender_id: number;
  chat_id: number;

  constructor(source: any) {
    this.id = source.id;
    this.sender_id = source.sender_id;
    this.sentAt = source.sentAt;
    this.content = source.content;
    this.chat_id = source.chat_id;
  }
}

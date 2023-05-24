export class ChatItemModel {
  id: string;
  name: string;

  constructor(source: any) {
    this.id = source.id;
    this.name = source.name;
  }
}

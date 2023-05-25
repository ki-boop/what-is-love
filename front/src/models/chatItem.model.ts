export class ChatItemModel {
  id: number;
  name: string;

  constructor(source: any) {
    this.id = source.id;
    this.name = source.name;
  }
}

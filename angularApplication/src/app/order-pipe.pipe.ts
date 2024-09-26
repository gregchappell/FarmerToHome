import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'orderPipe'
})
export class OrderPipePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    return null;
  }

}

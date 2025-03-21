import { Book } from 'lucide-react';
import React from 'react';

export default function CategoryItem() {
  return (
	<div className='flex justify-between my-4'>
		<div className='flex gap-2'>
			<Book />
			<span>nome</span>
		</div>
		<div>
			<span>dropdown</span>
		</div>
	</div>
  )
}

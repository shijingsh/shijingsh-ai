package com.shijingsh.rns.data.processor;

import com.shijingsh.ai.data.DataInstance;
import com.shijingsh.ai.data.DataModule;
import com.shijingsh.ai.data.IntegerArray;
import com.shijingsh.ai.data.module.ReferenceModule;
import com.shijingsh.ai.data.processor.DataSorter;
import com.shijingsh.core.utility.RandomUtility;

public class RandomDataSorter implements DataSorter {

    @Override
    public int sort(DataInstance left, DataInstance right) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ReferenceModule sort(DataModule module) {
        int size = module.getSize();
        IntegerArray reference = new IntegerArray(size, size);
        for (int index = 0; index < size; index++) {
            reference.associateData(index);
        }
        int from = 0;
        int to = size;
        for (int index = from; index < to; index++) {
            int random = RandomUtility.randomInteger(from, to);
            int data = reference.getData(index);
            reference.setData(index, reference.getData(random));
            reference.setData(random, data);
        }
        return new ReferenceModule(reference, module);
    }

}

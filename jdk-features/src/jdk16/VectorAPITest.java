package jdk16;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 练习使用 Vector API.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/12/9 14:45
 */
public class VectorAPITest {

    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_256;

    static void vectorComputation(float[] a, float[] b, float[] c) {
        var i = 0;
        var upperBound = SPECIES.loopBound(a.length);
        for (; i < upperBound; i += SPECIES.length()) {
            var va = FloatVector.fromArray(SPECIES, a, i);
            var vb = FloatVector.fromArray(SPECIES, b, i);
            var vc = va.mul(va).
                    add(vb.mul(vb)).
                    neg();
            vc.intoArray(c, i);
        }
        for (; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
    }

    static void oldComputation(float[] a, float[] b, float[] c) {
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
    }

    static void main(String[] args) {
        var a = new float[10000000];
        var b = new float[10000000];
        var c = new float[10000000];
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextFloat(0, 100);
            b[i] = random.nextFloat(0, 100);
            c[i] = random.nextFloat(0, 100);
        }
        // 使用向量 API 计算比传入 for 循环计算更快.
        vectorComputation(a, b, c);
    }
}

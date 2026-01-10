package com.java.loader;

import java.awt.AWTException;

/* loaded from: Vene.jar:com/java/loader/b.class */
public final class b extends Thread {
    private a a;
    private boolean b = false;

    /* renamed from: a, reason: collision with other field name */
    private boolean f16a = false;

    public b(boolean z) {
        try {
            this.a = new a();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            a(1L);
            if (this.f16a) {
                int i = (!c.f18b || a.a() <= 0.7d) ? c.a : (int) (c.a * 0.75d);
                long jA = ((int) (a.a() * (((1000 / i) - (1000 / c.b)) + 1))) + (1000 / c.b);
                long jA2 = ((int) (a.a() * 11)) + 30;
                long j = jA - jA2;
                a(jA2);
                if (this.b) {
                    this.a.d();
                } else {
                    this.a.b();
                }
                a(j);
                if (this.f16a) {
                    if (this.b) {
                        this.a.c();
                    } else {
                        this.a.m1a();
                    }
                    if (c.e != 0 && c.f != 0) {
                        this.a.a(c.e, c.f);
                    }
                }
            }
        }
    }

    public final long a() {
        return this.a.m0a();
    }

    private static void a(long j) {
        try {
            sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void a(boolean z) {
        this.f16a = z;
    }
}